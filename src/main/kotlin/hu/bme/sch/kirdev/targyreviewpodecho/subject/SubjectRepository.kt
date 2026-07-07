package hu.bme.sch.kirdev.targyreviewpodecho.subject

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SubjectRepository : JpaRepository<SubjectEntity, Long> {

}
