import java.util.*;

public class Main {
    enum WeekDay {SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY}

    public static void main(String[] args) {
        List<WeekDay> annsWorkDays = new ArrayList<>(List.of(WeekDay.MONDAY, WeekDay.TUESDAY, WeekDay.THURSDAY, WeekDay.FRIDAY));
        var annsDaySet = EnumSet.copyOf(annsWorkDays);
        //RegularEnumSet = up to 64 bits, benefit is that it's stored in bit vector as ordinal enum values
        System.out.println(annsDaySet.getClass().getSimpleName());
        annsDaySet.forEach(System.out::println);
        //can also set all of the ENUM values to EnumSet
        var allDaysSet = EnumSet.allOf(WeekDay.class);
        System.out.println("-".repeat(20));
        allDaysSet.forEach(System.out::println);
        //can also get complement
        Set<WeekDay> newPersonDays = EnumSet.complementOf(annsDaySet);
        System.out.println("-".repeat(20));
        newPersonDays.forEach(System.out::println);
        System.out.println("-".repeat(20));
        //can also get complement by removing
        Set<WeekDay> anotherSet = EnumSet.copyOf(allDaysSet);
        anotherSet.removeAll(annsWorkDays);
        anotherSet.forEach(System.out::println);
        System.out.println("-".repeat(20));
        Set<WeekDay> businessDays = EnumSet.range(WeekDay.MONDAY,WeekDay.FRIDAY);
        businessDays.forEach(System.out::println);
        System.out.println("-".repeat(20));
        //below is the map implementation of Enum to store DAYS and the ppl working on it
        Map<WeekDay, String[]> employeeMap = new EnumMap<WeekDay, String[]>(WeekDay.class);
        employeeMap.put(WeekDay.FRIDAY, new String[]{"Peter","Marlin","Joe"});
        employeeMap.forEach((k,v)-> System.out.println(k+" :"+Arrays.toString(v)));

    }
}