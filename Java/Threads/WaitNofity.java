/**
	Question: Explain Wait, Notify, NotifyAll.

	Explanation: 
	Consider a mail box. Using the wait and notify mechanism the mail processor thread chould check for mail and if it does not find any new mail then, 
	"Hey, I'm not going to waste my time checking for mail every two seconds. I'm going to go hang out, and when the mail
	 deliverer puts something in the mailbox, have him notify me so I can go back to runnable and do some work."

	NOTE: wait(), notify(), and notifyAll() must be called from within a synchronized context! A thread can't invoke a wait or notify method on an object unless it owns that object's lock.
*/


class WaitNotify {

}