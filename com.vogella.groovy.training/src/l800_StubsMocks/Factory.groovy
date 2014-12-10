

package l800_StubsMocks

class Factory {

    def numbers
    def worker

    // defaults to a Hard (and slow) Worker implementation
    Factory(worker = new HardWorker(), def numbers) {
        this.numbers = numbers
        this.worker = worker
    }

    def work() {
        numbers.collect {
            worker.work(it)
        }
    }

}
