package core.helpers.driverhelper;

import java.util.ArrayList;
import java.util.List;

import static core.helpers.driverhelper.DriverName.CHROME;
import static core.helpers.driverhelper.DriverName.FIREFOX;
import static core.helpers.driverhelper.DriverOpts.HEADLESS;

public class OptionsMapper {
    private List<String> options = new ArrayList<>();
    private String driverName;

    public OptionsMapper(String _driverName) {
        this.driverName = _driverName;
    }

    public OptionsMapper withOption(String option) {
        this.options.add(generateOptionArgument(this.driverName, option));
        return this;
    }

    public List<String> build() {
        return this.options;
    }

    private String generateOptionArgument(String driverName, String option) {
        String arg = null;
        if (option.equals(HEADLESS) && (driverName.equalsIgnoreCase(CHROME)  || driverName.equalsIgnoreCase(FIREFOX))) {
            arg = "--headless";
        }
        else{
            arg = option;
        }
        return arg;
    }
}
