package ru.job4j.stream;

import java.util.Objects;

public class Pump {
    private String name;
    private String install;
    private String launch;
    private String stop;
    private String deinstall;
    private String reason;
    private int operating;

    static class Builder {
        private String name;
        private String install;
        private String launch;
        private String stop;
        private String deinstall;
        private String reason;
        private int operating;

        Builder buildName(String name) {
            this.name = name;
            return this;
        }

        Builder buildInstall(String install) {
            this.install = install;
            return this;
        }

        Builder buildLaunch(String launch) {
            this.launch = launch;
            return this;
        }

        Builder buildStop(String stop) {
            this.stop = stop;
            return this;
        }

        Builder buildDeinstall(String deinstall) {
            this.deinstall = deinstall;
            return this;
        }

        Builder buildReason(String reason) {
            this.reason = reason;
            return this;
        }

        Builder buildOperating(int operating) {
            this.operating = operating;
            return this;
        }

        Pump build() {
            Pump pump = new Pump();
            pump.name = name;
            pump.install = install;
            pump.launch = launch;
            pump.stop = stop;
            pump.deinstall = deinstall;
            pump.reason = reason;
            pump.operating = operating;
            return pump;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this != o) {
            if (o != null && getClass() == o.getClass()) {
                Pump pump = (Pump) o;
                return Objects.equals(name, pump.name) && Objects.equals(install, pump.install);
            } else {
                return false;
            }
        } else {
            return true;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, install);
    }

    @Override
    public String toString() {
        return "Pump{"
                + "name='" + name + '\''
                + ", install='" + install + '\''
                + ", launch='" + launch + '\''
                + ", stop='" + stop + '\''
                + ", deinstall='" + deinstall + '\''
                + ", reason='" + reason + '\''
                + ", operating=" + operating
                + '}';
    }
}
