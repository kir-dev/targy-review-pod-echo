package hu.bme.sch.kirdev.targyreviewpodecho.subject

import jakarta.persistence.EntityNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class SubjectService(private val subjectRepository: SubjectRepository, private val subjectMapper: SubjectMapper) {

    @Transactional
    fun createSubject(subject: SubjectDto) : SubjectDto{
        val subjectEntity = subjectMapper.dtoToEntity(subject)
        subjectRepository.save(subjectEntity)
        return subjectMapper.entityToDto(subjectEntity)
    }

    @Transactional
    fun updateSubject(subject: SubjectDto, id: Long) : SubjectDto{
        val subjectEntityToUpdate = subjectRepository.findById(id).orElseThrow{ EntityNotFoundException("Subject not found") }
        subjectMapper.updateEntityFromDto(subjectEntityToUpdate, subject)
        val subjectDto = subjectRepository.save(subjectEntityToUpdate)
        return subjectMapper.entityToDto(subjectDto)
    }

    @Transactional
    fun deleteSubject(id: Long) {
        val subjectEntityToDelete = subjectRepository.findById(id).orElseThrow{ EntityNotFoundException("Subject not found") }
        subjectRepository.deleteById(id)
    }

    @Transactional(readOnly = true)
    fun getSubject(id: Long): SubjectDto {
        val subject = subjectRepository.findById(id).orElseThrow{ EntityNotFoundException("Subject not found") }
        return subjectMapper.entityToDto(subject)
    }

    @Transactional(readOnly = true)
    fun getAllSubjects(): List<SubjectDto> {
        val subjects = subjectRepository.findAll()
        return subjects.map{ subject -> subjectMapper.entityToDto(subject)}
    }
}
