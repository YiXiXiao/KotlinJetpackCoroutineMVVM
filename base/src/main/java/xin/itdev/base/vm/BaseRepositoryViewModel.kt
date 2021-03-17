package xin.itdev.base.vm

import android.app.Application
import xin.itdev.base.repository.BaseRepository
/**
 * @author xyx
 * @date 2021/03/11
 */
abstract class BaseRepositoryViewModel<T : BaseRepository>(app:Application, val mRepo : T): BaseLayoutViewModel(app) {
}