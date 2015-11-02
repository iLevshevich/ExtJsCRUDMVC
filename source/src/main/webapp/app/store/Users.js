/**
 * Created by levshevich_i on 29.10.15.
 */
Ext.define('ExtJSTest.store.Users', {
    extend: 'Ext.data.Store',
    model: 'ExtJSTest.model.User',
    autoLoad: true,
    pageSize: 10,
    autoLoad: {start: 0, limit: 10},

    proxy: {
        type: 'ajax',
        api: {
            read : 'users/view.action',
            create : 'users/add.action',
            update: 'users/update.action',
            destroy: 'users/remove.action'
        },
        reader: {
            type: 'json',
            root: 'data',
            successProperty: 'success'
        },
        writer: {
            type: 'json',
            writeAllFields: true,
            encode: false,
            root: 'data'
        },
        actionMethods: {
            read: 'GET',
            create: 'PUT',
            update: 'POST',
            destroy: 'DELETE'
        },
        listeners: {
            exception: function(proxy, response, operation){
                Ext.MessageBox.show({
                    title: 'REMOTE EXCEPTION',
                    msg: operation.getError(),
                    icon: Ext.MessageBox.ERROR,
                    buttons: Ext.Msg.OK
                });
            }
        }
    }
});