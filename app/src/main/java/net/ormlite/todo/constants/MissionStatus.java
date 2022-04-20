package net.ormlite.todo.constants;

public enum MissionStatus {
  NEW(1),         //新建
  PROGRESS(2),    //进行中
  COMPLETED(10);  //完成

  private int num;

  MissionStatus(int num) {
    this.num = num;
  }
}