package xin.itdev.qa.bean

data class ItemQaBean(
    var apkLink: String?,
    var audit: Int?,
    var author: String?,
    var canEdit: Boolean?,
    var chapterId: Int?,
    var chapterName: String?,
    var collect: Boolean?,
    var courseId: Int?,
    var desc: String?,
    var descMd: String?,
    var envelopePic: String?,
    var fresh: Boolean?,
    var id: Int?,
    var originId: Int?,
    var link: String?,
    var niceDate: String?,
    var niceShareDate: String?,
    var origin: String?,
    var prefix: String?,
    var projectLink: String?,
    var publishTime: Long?,
    var selfVisible: Int?,
    var shareDate: Long?,
    var shareUser: String?,
    var superChapterId: Int?,
    var superChapterName: String?,
    var tags: List<TagBean>?,
    var title: String?,
    var type: Int?,
    var userId: Int?,
    var visible: Int?,
    var zan: Int?,
    val imagePath: String? = null,
    val isVisible: Int? = null,
    val order: Int? = null,
    val url: String? = null,
    val name: String? = null,
    //=====coin rank=========
    val coinCount: Int? = null,
    val level: Int? = null,
    val rank: String? = null,
    val username: String? = null
    //=====coin rank=========
) {
    data class TagBean(var name: String?, var url: String? = null)
}