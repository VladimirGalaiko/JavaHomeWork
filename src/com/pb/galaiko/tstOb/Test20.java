package com.pb.galaiko.tstOb;
import java.util.ArrayList;
public class Test20 {
    public static void main(String[] args) {
        ArrayList<String> st = new ArrayList<>(4);
        st.add(0, "1");
        st.add(1, "2");
        st.add(2, "3");
        st.add(3, "4");
        st.remove(0);
        for (String s : st) {
            System.out.println(s);
        }

    }
}
