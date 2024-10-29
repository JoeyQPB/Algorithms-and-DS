package joey.com.algorithms;

public class BinarySearch<E extends Comparable<E>> {

    public static class Response<E> {
        private E value;
        private Integer tries;
        private Boolean find;

        public Response(E value, Integer tries, Boolean find) {
            this.value = value;
            this.tries = tries;
            this.find = find;
        }

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }

        public Integer getTries() {
            return tries;
        }

        public void addTry() {
            this.tries++;
        }

        public Boolean getFind() {
            return find;
        }

        public void setFind(Boolean find) {
            this.find = find;
        }

        @Override
        public String toString() {
            return "VALUE: " + value + " - TRIES: " + tries + " - FIND: " + find;
        }
    }

    public Response<E> search(E[] arr, E el) {
        int start = 0;
        int end = arr.length - 1;
        E pointer;
        Response<E> resp = new Response<E>(null, 0, false);

        while (end >= start) {
            resp.addTry();
            int mid = (start + end)/2;
            pointer = arr[mid];
            int cpt = pointer.compareTo(el);

            if (cpt == 0) {
                resp.setFind(true);
                resp.setValue(pointer);
                break;
            } else if (cpt < 0) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return resp;
    }

    public static Response<Integer> searchRec(Integer[] arr, int el, int start, int end, Response<Integer> resp) {
        if (end >= start) {
            resp.addTry();
            int mid = (start + end) / 2;

            if (arr[mid] == el) {
                resp.setValue(arr[mid]);
                resp.setFind(true);
            } else if (arr[mid] > el) {
               searchRec(arr, el, start, mid - 1, resp);
            } else {
                searchRec(arr, el, mid + 1, end, resp);
            }
        }
        return resp;
    }
}


//Integer[] arr = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//BinarySearch<Integer> binarySearch = new BinarySearch<>();
//
//        System.out.println("BINARY SEARCH");
//        System.out.println("TRIES: 3    - " + binarySearch.search(arr, 1));
//        System.out.println("TRIES: 1    - " + binarySearch.search(arr, 5));
//        System.out.println("TRIES: 3    - " + binarySearch.search(arr, 3));
//        System.out.println("TRIES: 2    - " + binarySearch.search(arr, 2));
//        System.out.println("TRIES: 2    - " + binarySearch.search(arr, 8));
//        System.out.println("TRIES: 4    - " + binarySearch.search(arr, 7));
//        System.out.println("TRIES: 4    - " + binarySearch.search(arr, 10));
//        System.out.println("TRIES: 4    - " + binarySearch.search(arr, 11));
//
//        System.out.println();
//        System.out.println("BINARY SEARCH REC");
//
//        System.out.println("TRIES: 3    - " + BinarySearch.searchRec(arr, 1, 0, arr.length -1, new BinarySearch.Response<>(null, 0, false)));
//        System.out.println("TRIES: 1    - " + BinarySearch.searchRec(arr, 5, 0, arr.length -1, new BinarySearch.Response<>(null, 0, false)));
//        System.out.println("TRIES: 3    - " + BinarySearch.searchRec(arr, 3, 0, arr.length -1, new BinarySearch.Response<>(null, 0, false)));
//        System.out.println("TRIES: 2    - " + BinarySearch.searchRec(arr, 2, 0, arr.length -1, new BinarySearch.Response<>(null, 0, false)));
//        System.out.println("TRIES: 2    - " + BinarySearch.searchRec(arr, 8, 0, arr.length -1, new BinarySearch.Response<>(null, 0, false)));
//        System.out.println("TRIES: 4    - " + BinarySearch.searchRec(arr, 7, 0, arr.length -1, new BinarySearch.Response<>(null, 0, false)));
//        System.out.println("TRIES: 4    - " + BinarySearch.searchRec(arr, 10, 0, arr.length -1, new BinarySearch.Response<>(null, 0, false)));
//        System.out.println("TRIES: 4    - " + BinarySearch.searchRec(arr, 11, 0, arr.length -1, new BinarySearch.Response<>(null, 0, false)));
