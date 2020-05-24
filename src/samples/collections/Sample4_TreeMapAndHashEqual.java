package samples.collections;

import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class Sample4_TreeMapAndHashEqual {

    static class Code implements Comparable<Code> {

        String sectionNo;
        String lectureNo;

        public Code(String sectionNo, String lectureNo) {
            this.sectionNo = sectionNo;
            this.lectureNo = lectureNo;
        }

        public String getSectionNo() {
            return sectionNo;
        }

        public void setSectionNo(String sectionNo)
        {
            this.sectionNo = sectionNo;
        }

        public String getLectureNo() {
            return lectureNo;
        }

        public void setLectureNo(String lectureNo) {
            this.lectureNo = lectureNo;
        }

        @Override
        public String toString() {
            return "Code [Section: " + this.sectionNo + ", Lecture: " + this.lectureNo + "]";
        }

        @Override
        public int compareTo(Code o) {
            String code1 = sectionNo.concat(lectureNo);
            String code2 = o.getSectionNo() + o.getLectureNo();

            return  code1.compareTo(code2);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Code code = (Code) o;
            return Objects.equals(sectionNo, code.sectionNo) &&
                    Objects.equals(lectureNo, code.lectureNo);
        }

        @Override
        public int hashCode() {
            return Objects.hash(sectionNo, lectureNo);
        }
    }

    public static void main(String[] args) {

        // TreeMap doesn't allow duplicate keys.
        // Elements of tree map must implement comparable.

        Map<Code, String> lectures = new TreeMap<>();

        lectures.put(new Code("S01", "L01"), "Generics");
        lectures.put(new Code("S04", "L02"), "OOP");
        lectures.put(new Code("S04", "L01"), "IO");
        lectures.put(new Code("S05", "L03"), "Streams");
        lectures.put(new Code("S02", "L03"), "Spring");
        lectures.put(new Code("S03", "L05"), "JDBC");
        lectures.put(new Code("S02", "L01"), "JDBC");
        lectures.put(new Code("S02", "L07"), "JDBC");

        System.out.println("*****   Key based alphabetically ordered list   *****");

        for (Map.Entry<Code, String> entry : lectures.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
        }

        System.out.println("*****   HashCode sample   *****");

        Code c1 = new Code("S01", "L01");
        Code c2 = new Code("S01", "L01");

        // Without equal method overriding, equal method returns false.

        System.out.println(c1.equals(c2));
    }
}
