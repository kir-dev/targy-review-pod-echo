package hu.bme.sch.kirdev.targyreviewpodecho.user

data class UserDto(
    var id: Long? = null,

    var fullName: String = "",

    var email: String = "",

    var internalId: String = "",

    var role: UserRole = UserRole.REGULAR_USER
)
