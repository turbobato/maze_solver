package core;

public class MazeReadingException extends Exception {
    
    private final String fileName;
    private final String Message;
    private final int line;


    public MazeReadingException(String fileName, int line, String Message){
        super(Message + "à la ligne " + line + "du fichier :" + fileName );
        this.fileName = fileName;
        this.line = line;
        this.Message=Message;
    }

    public String getFileName(){
        return fileName;
    }

    public int getLine(){
        return line;
    }

    public String getMessage(){
        return Message;
    }
}
