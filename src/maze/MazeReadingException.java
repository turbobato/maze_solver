package core;

public class MazeReadingException extends Exception {
    
    private final String fileName;
    private final String ErrorMessage;
    private final int line;


    public MazeReadingException(String fileName, int line, String ErrorMessage){
        super(ErrorMessage + " à la ligne " + line + " du fichier : " + fileName );
        this.fileName = fileName;
        this.line = line;
        this.ErrorMessage=ErrorMessage;
    }

    public String getFileName(){
        return fileName;
    }

    public int getLine(){
        return line;
    }

    public String getErrorMessage(){
        return ErrorMessage;
    }
}
