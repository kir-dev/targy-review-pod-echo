package hu.bme.sch.kirdev.targyreviewpodecho.teacher

class TeacherMapper {
    fun entityToDto(entity: TeacherEntity): TeacherDto {
        return TeacherDto(
            id = entity.id,
            name = entity.name ?: ""
            //subject needed
        )
    }

    fun dtoToEntity(dto: TeacherDto): TeacherEntity {
        return TeacherEntity(
            name = dto.name ?: ""
            //subject needed
        )
    }
    fun updateEntityFromDto(dto: TeacherDto, entity: TeacherEntity) {
        entity.name = dto.name
        //subject needed
    }
}