

package l800_StubsMocks

class HardWorker implements Worker {

    @Override
    int work(int number) {
        Thread.sleep(1000)
        return number + 10
    }
}
