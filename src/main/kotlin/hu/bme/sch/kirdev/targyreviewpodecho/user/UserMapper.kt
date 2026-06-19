package hu.bme.sch.kirdev.targyreviewpodecho.user

class UserMapper {
    fun entityToDto(entity: UserEntity): UserDto {
        return UserDto(
            id = entity.id,
            fullName = entity.fullName,
            email = entity.email,
            internalId = entity.internalId,
            role = entity.role
        )
    }

    fun dtoToEntity(dto: UserDto): UserEntity {
        return UserEntity(
            // id is generated
            fullName = dto.fullName,
            email = dto.email,
            internalId = dto.internalId,
            role = dto.role
        )
    }

    fun updateEntityFromDto(entity: UserEntity, dto: UserDto) {
        // id will not change since it is generated
        entity.fullName = dto.fullName
        entity.email = dto.email
        // could there be a situation where we
        // have to update internalId (which we got from AuthSCH)?
        // entity.internalId = dto.internalId
        entity.role = dto.role
    }
}