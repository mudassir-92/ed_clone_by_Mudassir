import java.util.regex.*
class InterfaceED {
    val ed=Editor()
    // start the event
    fun startEditor()
    {
        var choice:String
        do {
            choice=readln()
            var cmd=choice.replace(" ","")
            val ra= Regex("^(\\d*p)(,\\d*p)*$", RegexOption.IGNORE_CASE)
            var areg=Regex("^\\d*a", RegexOption.IGNORE_CASE)
            var ireg=Regex("^\\d*i", RegexOption.IGNORE_CASE)
            var dreg=Regex("^\\d*d", RegexOption.IGNORE_CASE)
            var w=Regex("w", RegexOption.IGNORE_CASE)
            var help=Regex("h", RegexOption.IGNORE_CASE)
            if(cmd.matches(ra))
            {
                handlePrinting(cmd)
            }
            else if(cmd.matches(areg))
            {
                handleAppendig(cmd)
            }
            else if(cmd.matches(ireg))
            {
                handleInserting(cmd)
            }
            else if(cmd.matches(dreg))
            {
                handleDeleting(cmd)
            }
            else if(cmd.matches(w))
            {
                ed.writeToFile()
            }
            else if(cmd.matches(help))
            {
                ed.help()
            }
            else
            {
               println("ERRRROR")
            }
        }while (true)
    }
    private fun handleDeleting(cmd: String) {
        var temp = cmd.substring(0, cmd.length - 1)
        var pos = ed.totalLines()
        if (temp.isEmpty()) {
           ed.deleteline(ed.totalLines())
        } else {
            // its range bro
            var temp=cmd
            temp=temp.replace("p","",true)
            val split = temp.split(",")
            var start=split.get(0).toInt()
            var end=split.get(1).toInt()
            ed.deleteRange(start,end)
        }
    }
    private fun handleInserting(cmd: String) {
        var temp = cmd.substring(0, cmd.length - 1)
        var pos = ed.totalLines()
        if (temp.isEmpty()) {
            var ent: String
            do {
                ent = readln()
                if (!ent.replace(" ", "").equals(".")) {
                    ed.appendLine(ent,ed.totalLines()-1)
                } else {
                    break
                }
            } while (true)
        } else {
            var po = temp.toInt()
            /// append at the given pos
            var ent: String
            do {
                ent = readln()
                if (!ent.replace(" ", "").equals(".")) {
                    ed.insertLine(ent,pos)
                    po += 1
                } else {
                    break
                }
            } while (true)
        }
    }
    private fun handleAppendig(cmd: String) {
        var temp=cmd.substring(0,cmd.length-1)
        var pos=ed.totalLines()
        if(temp.isEmpty())
        {
            var ent:String
            do {
                ent=readln()
                if(!ent.replace(" ","").equals("."))
                {
                    ed.appendLine(ent)
                }
                else
                {
                    break
                }
            }while (true)
        }
        else
        {
            var po=temp.toInt()
            /// append at the given pos
            var ent:String
            do {
                ent=readln()
                if(!ent.replace(" ","").equals("."))
                {
                    ed.appendLine(ent,(po)-1)
                    po+=1
                }
                else
                {
                    break
                }
            }while (true)
        }
    }
    private fun handlePrinting(cmd:String)
    {
        val ra= Regex("^(\\d*p)$", RegexOption.IGNORE_CASE)
        // it contain now p and which line
        if(cmd.matches(ra))
        {
            var temp=cmd.substring(0,cmd.length-1)
            if(temp.isEmpty())
            {
                ed.printLine()
            }
            else
            {
                var lineNumber=temp.toInt();
                ed.printLine(lineNumber)
            }
        }
        else
        {
            // its range bro
            var temp=cmd
            temp=temp.replace("p","",true)
            val split = temp.split(",")
            var start=split.get(0).toInt()
            var end=split.get(1).toInt()
            ed.printRangeOfLine(start,end)
        }

    }
}