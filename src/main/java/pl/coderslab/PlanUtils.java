package pl.coderslab;

import pl.coderslab.model.GradeSubjectTeacher;
import pl.coderslab.model.Schedule;

import java.util.List;

public class PlanUtils {

    private static int hourToNumber(String hour) {
        switch (hour) {
            case "8:00":
                return 0;
            case "8:55":
                return 1;
            case "9:50":
                return 2;
            case "10:45":
                return 3;
            case "11:40":
                return 4;
            case "12:35":
                return 5;
            case "13:30":
                return 6;
            case "14:25":
                return 7;
        }
        return 0;
    }

    private static int dayToNumber(String day) {
        switch (day) {
            case "Monday":
                return 0;
            case "Tuesday":
                return 1;
            case "Wednesday":
                return 2;
            case "Thursday":
                return 3;
            case "Friday":
                return 4;
        }
        return 0;
    }

    public static GradeSubjectTeacher[][] getGsts(List<Schedule> schedules){
        GradeSubjectTeacher[][] allGsts;
        allGsts = new GradeSubjectTeacher[8][5];
        for(Schedule schedule:schedules){
            if(schedule.getDayOfWeek() != null && schedule.getStartHour() != null){
                allGsts[hourToNumber(schedule.getStartHour())]
                        [dayToNumber(schedule.getDayOfWeek())] = schedule.getGst();
            }
        }
        return allGsts;
    }


}
