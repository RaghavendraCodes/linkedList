public class mergeSort {


    LL merge(LL list1, LL list2) {
        LL dummyhead = new LL(); 
        LL tail = dummyhead; 
        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                tail.next = list1; 
                list1 = list1.next; 
                tail = tail.next; 
            } else {
                tail.next = list2; 
                list2 = list2.next; 
                tail = tail.next; 
            }
        }
        tail.next = (list1 != null) ? list1 : list2; 
        return dummyhead.next; 
    }

    LL getMid(LL head) {
        LL midPrev = null; 
       
    }
    
}
