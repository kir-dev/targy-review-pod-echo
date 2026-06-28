package hu.bme.sch.kirdev.targyreviewpodecho.teacher

class TeacherMapper {
    fun entityToDto(entity: TeacherEntity): TeacherDto {
        //subject needed
        return TeacherDto(
            id = entity.id,
            name = entity.name ?: ""
        )
    }

    fun dtoToEntity(dto: TeacherDto): TeacherEntity {
        //subject needed
        return TeacherEntity(
            name = dto.name ?: ""
        )
    }
}