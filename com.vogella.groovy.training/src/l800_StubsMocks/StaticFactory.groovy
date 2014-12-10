

package l800_StubsMocks

class StaticFactory {

    List<Integer> numbers

    public static Worker getWorker() {
        new HardWorker()
    }

    List<Integer> work() {
        numbers.collect {
            getWorker().work(it)
        }
    }


}
