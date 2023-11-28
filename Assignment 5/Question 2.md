# Question 2
    Write a precondition or requires clause for the method removeDuplicates, so all duplicates from List lst are removed.
##     
    public static void removeDuplicates(List lst) {
        requires: lst must not be null, lst must have a size greater than 0,
                  all duplicates must be sequential to each other (in a line)
        if (lst == null || lst.size() == 0) return;
        List copy = new ArrayList(list);
        Iterator elements = copy.iterator();
        Object pre = elements.next();
        while(elements.hasNext()) {
            Object nex = elements.next();
            if (pre.equals(nex)) lst.remove(nex);
            else pre = nex;
        }
    }