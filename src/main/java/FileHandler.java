public class FileHandler {

    private Range currentRange;

    public FileHandler(Range range){
        this.currentRange = range;
    }

    public String createSaveString(){
        StringBuilder builder = new StringBuilder();
        builder.append("pg ");
        builder.append(currentRange.start);
        builder.append(" thru ");
        builder.append(currentRange.end);
        return builder.toString();
    }

}
