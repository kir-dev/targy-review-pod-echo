package hu.bme.sch.kirdev.targyreviewpodecho.subject

data class SubjectDto (
    var id: Long? = null,

    var name: String = "",

    var semester: Int = 0,

    var major: MajorType = MajorType.MERNOK_INFO,

    var bmeId: String = "",

    var description: String = ""
)