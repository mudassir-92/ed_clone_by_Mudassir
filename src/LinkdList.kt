//class LinkedList<T>(size: Int = 0) {
//
//    val head: Node<T> = Node(null, 0)
//    private var tail: Node<T> = head
//    private var iter = 0
//
//    init {
//        if (size < 0)
//            throw IllegalArgumentException("Size should not be negative")
//
//        for (i in 1..size) {  // start from 1 to avoid creating one extra node
//            val temp = Node<T>(null, tail.lineNumber + 1)
//            tail.next = temp
//            tail = temp
//        }
//    }
//
//    fun getHead():Node<T>
//    {
//        return head;
//    }
//    fun insertAt(pos:Int=-1): Boolean
//    {
//        if(pos>tail.lineNumber)
//            throw Throwable("Bhai this jgah does not exists")
//        if(pos==-1)
//        {
//            // at end else at before line number
//
//        }
//        else
//        {
//            var t: Node<T>? =head
//            while(t?.next?.value!=pos)
//            {
//                t=t?.next
//            }
//            //
//        }
//    }
//
//
//}
