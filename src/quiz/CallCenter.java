package quiz;


import java.util.Queue;

public class CallCenter {
    Queue<CustomerSupportRep> mSupportReps;

    public CallCenter(Queue<CustomerSupportRep> queue) {
        mSupportReps = queue;
    }

    public void acceptCustomer(Customer customer) {

        /********************************************
         * TODO (1)
         * Wait until there is an available rep in the queue.
         * While there is not one available, playHoldMusic
         * HINT: That while assignment check loop syntax we used to
         *      read files seems pretty similar
         ********************************************
         */
        CustomerSupportRep csr;
        while(mSupportReps.isEmpty()){
            playHoldMusic();
        }

        csr = mSupportReps.poll();
        csr.assist(customer);
        mSupportReps.add(csr);
        /********************************************
         * TODO (2)
         * After we have assigned the rep, call the
         * assist method and pass in the customer
         ********************************************
         */
        /********************************************
         * TODO (3)
         * Since the customer support rep is done with
         * assisting, put them back into the queue.
         ********************************************
         */

    }

    public void playHoldMusic() {
        System.out.println("Smooooooth Operator.....");
    }

}