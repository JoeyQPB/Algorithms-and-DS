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
            } else if (cpt < 0) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return resp;
    }

}
