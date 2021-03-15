package xin.itdev.common.vm

import android.app.Application
import xin.itdev.common.repository.BaseRepository
/**
 * @author xyx
 * @date 2021/03/11
 */
abstract class BaseRepositoryViewModel<T : BaseRepository>(app:Application, val mRepo : T): BaseLayoutViewModel(app) {
}