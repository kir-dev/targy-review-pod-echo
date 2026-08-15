package hu.bme.sch.kirdev.targyreviewpodecho.user

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<UserEntity, Long> {
    fun findByInternalId(internalId: String): UserEntity?
    fun findByEmail(email: String): UserEntity?
}