import java.io.File
class Editor {
    private val data = mutableListOf<String>()
    private val fileName="data.txt"
    private var file=File(fileName)
    fun appendLine(str:String,pos:Int=-1)
    {
        if(pos==-1 || pos>=data.size)
            data.add(str)
        else
            data.add(pos,str)
    }
    fun totalLines():Int
    {
        return data.size
    }

    fun insertLine(str:String,pos:Int)
    {
        appendLine(str,pos-1)
    }
    fun deleteline(pos:Int)
    {
        if(pos>data.size)
            println("Invalid Position")
        data.removeAt(pos-1)
    }
    fun deleteRange(start:Int,end:Int)
    {
        if(start<1 || end>data.size)
            println("Invalid Position")
        for (i in end downTo start)
            deleteline(i)
    }
    fun deleteAll()
    {
        data.clear()
    }

    fun printLine(pos:Int=-1)
    {
        if(pos>data.size)
            println("Invalid Position")
        if(pos==-1)
        {
            println(""+data.size+"> "+data.get(data.size-1))
            return
        }
        println(""+pos+"> "+data.get(pos-1))
    }
    fun printRangeOfLine(start:Int,end:Int)
    {
        if(start<1 || end>data.size)
            println("Invalid Position")
        for (i in start..end)
            printLine(i)
    }
    fun printAllLines()
    {
        printRangeOfLine(1,data.size)
    }
    fun help()
    {
        println("a  - append after line\n" +
                "i  - insert before line\n" +
                "d  - delete line(s)\n" +
                "p  - print line(s)\n" +
                "w  - write to file\n" +
                "q  - quit")
    }
    fun writeToFile()
    {
        for (i in 0 .. data.size)
        {
            file.appendText(data.get(i)+"\n")
        }
    }
    fun extractFromFile()
    {
        data.clear();
        if(file.exists())
        {
            file.forEachLine { line->
                data.add(line)
            }
        }
    }
}