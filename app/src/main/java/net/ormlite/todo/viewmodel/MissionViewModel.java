package net.ormlite.todo.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import net.ormlite.todo.repository.local.MissionDbRepository;
import net.ormlite.todo.ui.pojo.Mission;
import net.ormlite.todo.ui.pojo.MissionRecord;

import java.util.List;

public class MissionViewModel extends AndroidViewModel {
    private MutableLiveData<List<Mission>> taskLiveData;

    private MutableLiveData<Boolean> saveStatusLiveData,saveMissionRecordLiveData;

    public MissionViewModel(@NonNull Application application) {
        super(application);
        saveStatusLiveData = new MutableLiveData<>();
        taskLiveData = new MutableLiveData<>();
        saveMissionRecordLiveData = new MutableLiveData<>();
    }

    public MutableLiveData<List<Mission>> getAllMission() {
        List<Mission> missionList = MissionDbRepository.findAllOrderByCreateTime(getApplication(), false);
        taskLiveData.postValue(missionList);

        return taskLiveData;
    }

    public MutableLiveData<Boolean> getSaveStatusLiveData() {
        return saveStatusLiveData;
    }


    public void saveMission(Mission mission) {
        boolean isSuccess = MissionDbRepository.saveOrUpdate(getApplication(), mission);
        saveStatusLiveData.postValue(isSuccess);
    }

    public void saveMissionRecord(MissionRecord mission) {
        boolean isSuccess = MissionDbRepository.saveOrUpdateMissionRecord(getApplication(), mission);
        saveMissionRecordLiveData.postValue(isSuccess);
    }

} 