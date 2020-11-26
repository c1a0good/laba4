package se;

import java.util.*;
import java.sql.SQLException;

public class DepartmentManager {
    static public List<DepartmentEmployees> manage() {
            int max = 0;
            Collection<MyObject> beans = Storage.readAll();
            List<MyObject> objects = new ArrayList<MyObject>(beans);
            List<DepartmentEmployees> departmentEmployees = new ArrayList<>();
            HashMap<String, List<Double>> dateStamps = new HashMap<>();
            List<String> departments = new ArrayList<>();
            boolean key, keyDate1, keyDate2;
            for (MyObject o : objects) {
                if (!departments.isEmpty()) {
                    key = true;
                    for (String n : departments) {
                        if (n.equals(o.getDepartment())) {
                            key = false;
                            break;
                        }
                    }
                    if (key) {
                        departments.add(o.getDepartment());
                    }

                } else {
                    departments.add(o.getDepartment());
                }

            }
            for (String d : departments) {
                dateStamps.put(d, new ArrayList<>());
            }
            for (MyObject o : objects) {
                for (String dep : departments) {
                    if (dep.equals(o.getDepartment())) {
                        if (!dateStamps.get(dep).isEmpty()) {
                            keyDate1 = keyDate2 = true;
                            for (Double d : dateStamps.get(dep)) {
                                if (DataService.subDate(o.getStartDate()) == d) {
                                    keyDate1 = false;
                                }
                                if (DataService.subDate(o.getEndDate()) == d) {
                                    keyDate2 = false;
                                }
                            }
                            if (keyDate1) {
                                dateStamps.get(dep).add(DataService.subDate(o.getStartDate()));
                            }
                            if (keyDate2) {
                                dateStamps.get(dep).add(DataService.subDate(o.getEndDate()));
                            }
                        } else {

                            dateStamps.get(dep).add(DataService.subDate(o.getStartDate()));
                            dateStamps.get(dep).add(DataService.subDate(o.getEndDate()));
                        }
                    }
                }
            }
            for (String d : departments) {
                Collections.sort(dateStamps.get(d));
            }
            int temp, imax = 0;
            for (String d : departments) {
                max = 0;
                imax = 0;
                for (int i = 0; i < dateStamps.get(d).size() - 1; i++) {
                    temp = 0;
                    for (MyObject o : objects) {
                        if (d.equals(o.getDepartment())) {
                            if (DataService.subDate(o.getStartDate()) <= dateStamps.get(d).get(i) && DataService.subDate(o.getEndDate()) >= dateStamps.get(d).get(i + 1)) {
                                temp++;
                            }
                        }
                    }
                    if (temp > max) {
                        max = temp;
                        imax = i;
                    }
                }
                departmentEmployees.add(new DepartmentEmployees(d, max, DataService.revertDate(dateStamps.get(d).get(imax)), DataService.revertDate(dateStamps.get(d).get(imax + 1))));
            }
        return departmentEmployees;
    }
}
