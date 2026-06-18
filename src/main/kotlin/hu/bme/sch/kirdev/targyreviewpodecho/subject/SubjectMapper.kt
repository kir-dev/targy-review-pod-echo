package hu.bme.sch.kirdev.targyreviewpodecho.subject

class SubjectMapper {
    fun entityToDto(entity: SubjectEntity): SubjectDto {
        return SubjectDto(
            id = entity.id,
            name = entity.name,
            semester = entity.semester,
            major = entity.major,
            bmeId = entity.bmeId,
            description = entity.description
        )
    }

    fun dtoToEntity(dto: SubjectDto): SubjectEntity {
        return SubjectEntity(
            name = dto.name,
            semester = dto.semester,
            major = dto.major,
            bmeId = dto.bmeId,
            description = dto.description
        )
    }

    fun updateEntityFromDto(entity: SubjectEntity, dto: SubjectDto) {
        entity.name = dto.name
        entity.semester = dto.semester
        entity.major = dto.major
        entity.bmeId = dto.bmeId
        entity.description = dto.description
    }

}