import commands.filterSwitch;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;

public class Bot {

    public static void main (String args[]) throws Exception{

        JDA jda = new JDABuilder("NTMwMDg2NTU0ODYyMDkyMzA5.Dw6RSg.4Vd7Bn0scLE6gmZ2JSPc4HRRYQI").build();

        jda.addEventListener(new Filter());
        jda.addEventListener(new commands.filterSwitch());
        jda.addEventListener(new commands.filterMessage());


    }
}
