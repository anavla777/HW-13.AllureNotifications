package pages.components;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
        public void setDate(String day, String month, String year) {
            $(".react-datepicker__month-select").selectOption(month);
            $(".react-datepicker__year-select").selectOption(year);
            String formattedDay =  Integer.parseInt(day) > 9 ? day : "0" + day;
            $(String.format(".react-datepicker__day--0%s:not(.react-datepicker__day--outside-month)", formattedDay)).click();
        }
}
