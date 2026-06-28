package hu.bme.sch.kirdev.targyreviewpodecho.teacher

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TeacherRepository : JpaRepository<TeacherEntity, Long>{

}