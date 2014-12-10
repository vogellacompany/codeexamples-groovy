package l600_MetaObjectProtocol

class NukeInterceptor implements Interceptor {

    boolean isAuthorized = true

    @Override
    Object beforeInvoke(Object obj, String methodName, Object[] args) {
        // ------------ START EDITING HERE ----------------------
        if (methodName == 'nukeCity' && args[0] != 'admin')
            isAuthorized = false
        null
        // ------------ STOP EDITING HERE  ----------------------
    }

    @Override
    Object afterInvoke(Object obj, String methodName, Object[] args, Object result) {
        // ------------ START EDITING HERE ----------------------
        isAuthorized = true
        result
        // ------------ STOP EDITING HERE  ----------------------
    }

    @Override
    boolean doInvoke() {
        // ------------ START EDITING HERE ----------------------
        isAuthorized
        // ------------ STOP EDITING HERE  ----------------------
    }
}

