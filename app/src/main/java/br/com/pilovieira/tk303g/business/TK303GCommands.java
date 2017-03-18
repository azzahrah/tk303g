package br.com.pilovieira.tk303g.business;

import android.content.Context;

import br.com.pilovieira.tk303g.persist.Prefs;

public class TK303GCommands {

    private Context context;
    private Prefs prefs;

    public TK303GCommands(Context context) {
        this.context = context;
        this.prefs = new Prefs(context);
    }

    private String getPassword() {
        return prefs.getPassword();
    }

    private String go(String command) {
        return command.replace("#", getPassword());
    }

    public String getLocation() {
        return String.format("tel:%s", prefs.getTrackerNumber());
    }

    public String lockVehicle() {
        return go("stop#");
    }

    public String unlockVehicle() {
        return go("resume#");
    }

    public String begin() {
        return go("begin#");
    }

    public String monitor() {
        return go("monitor#");
    }

    public String tracker() {
        return go("tracker#");
    }

    public String changePassword(String oldPass, String newPass) {
        return go(String.format("password%s %s", oldPass, newPass));
    }

    public String authorizeNumber(String number) {
        return go(String.format("admin# %s", number));
    }

    public String deleteNumber(String number) {
        return go(String.format("noadmin# %s", number));
    }

}
