package id.g8id.api.entt.wh.entt

import id.g8id.api.cnst.ScheduleTask
import id.g8id.api.util.TimeUtil
import io.quarkus.mongodb.panache.kotlin.PanacheMongoCompanion
import io.quarkus.mongodb.panache.kotlin.PanacheMongoEntity
import java.time.LocalDateTime
import java.time.ZoneOffset

class SchdTaskLog(
    val taskCd: String,
    val totlCnt: Int,
    val succCnt: Int,
    val failCnt: Int,
    val mesg: String,
    val date: String,
    val rgstDttm: LocalDateTime = LocalDateTime.now(ZoneOffset.UTC)
) : PanacheMongoEntity() {

    companion object: PanacheMongoCompanion<SchdTaskLog> {
        fun saveCartScheduleTaskLog(totlCnt: Int, succCnt: Int) {
            val schdTaskLog = SchdTaskLog(
                taskCd = ScheduleTask.OLD_CART_ITEM,
                totlCnt = totlCnt,
                succCnt = succCnt,
                failCnt = totlCnt - succCnt,
                mesg = "Delete old cart item 2 weeks ago. total: $totlCnt, success: $succCnt, fail: ${totlCnt - succCnt}",
                date = TimeUtil.getTodayYyyyMMdd(),
            )
            schdTaskLog.persist()
        }

        fun saveAccessScheduleTaskLog(totlCnt: Int, succCnt: Int, userType: String) {
            val schdTaskLog = SchdTaskLog(
                taskCd = ScheduleTask.OLD_ACCESS_DATA,
                totlCnt = totlCnt,
                succCnt = succCnt,
                failCnt = totlCnt - succCnt,
                mesg = "Delete old $userType sign in history 3 months ago. total: $totlCnt, success: $succCnt, fail: ${totlCnt - succCnt}",
                date = TimeUtil.getTodayYyyyMMdd(),
            )
            schdTaskLog.persist()
        }

        fun saveRequestDataScheduleTaskLog(totlCnt: Int, succCnt: Int) {
            val schdTaskLog = SchdTaskLog(
                taskCd = ScheduleTask.OLD_REQUEST_DATA,
                totlCnt = totlCnt,
                succCnt = succCnt,
                failCnt = totlCnt - succCnt,
                mesg = "Delete old request data 1 week ago. total: $totlCnt, success: $succCnt, fail: ${totlCnt - succCnt}",
                date = TimeUtil.getTodayYyyyMMdd(),
            )
            schdTaskLog.persist()
        }

        fun saveRequestImageScheduleTaskLog(totlCnt: Int, succCnt: Int) {
            val schdTaskLog = SchdTaskLog(
                taskCd = ScheduleTask.OLD_REQUEST_IMAGE,
                totlCnt = totlCnt,
                succCnt = succCnt,
                failCnt = totlCnt - succCnt,
                mesg = "Delete old request image 1 week ago. total: $totlCnt, success: $succCnt, fail: ${totlCnt - succCnt}",
                date = TimeUtil.getTodayYyyyMMdd(),
            )
            schdTaskLog.persist()
        }

        fun savePaidHistScheduleTaskLog(totlCnt: Int, succCnt: Int) {
            val schdTaskLog = SchdTaskLog(
                taskCd = ScheduleTask.OLD_PAID_HISTORY,
                totlCnt = totlCnt,
                succCnt = succCnt,
                failCnt = totlCnt - succCnt,
                mesg = "Delete old paid history 3 months ago. total: $totlCnt, success: $succCnt, fail: ${totlCnt - succCnt}",
                date = TimeUtil.getTodayYyyyMMdd(),
            )
            schdTaskLog.persist()
        }

        fun saveConfirmPaidHistScheduleTaskLog(totlCnt: Int, succCnt: Int) {
            val schdTaskLog = SchdTaskLog(
                taskCd = ScheduleTask.CONFIRM_PAID_HISTORY,
                totlCnt = totlCnt,
                succCnt = succCnt,
                failCnt = totlCnt - succCnt,
                mesg = "Save confirm paid history log. total: $totlCnt, success: $succCnt, fail: ${totlCnt - succCnt}",
                date = TimeUtil.getTodayYyyyMMdd(),
            )
            schdTaskLog.persist()
        }
    }
}