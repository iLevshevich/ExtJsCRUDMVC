/**
 * Created by levshevich_i on 29.10.15.
 */
Ext.define('ExtJSTest.controller.Users', {
    extend: 'Ext.app.Controller',

    stores: ['Users'],

    models: ['User'],

    views: ['UserEdit', 'UserList'],

    refs: [{
        ref: 'contactsPanel',
        selector: 'panel'
    },{
        ref: 'contactlist',
        selector: 'contactlist'
    }
    ],

    init: function() {
        this.control({
            'contactlist dataview': {
                itemdblclick: this.editUser
            },
            'contactlist button[action=add]': {
                click: this.editUser
            },
            'contactlist button[action=delete]': {
                click: this.deleteUser
            },
            'contactedit button[action=save]': {
                click: this.updateUser
            }
        });
    },

    editUser: function(grid, record) {
        var edit = Ext.create('ExtJSTest.view.UserEdit').show();

        if(record){
            edit.down('form').loadRecord(record);
        }
    },

    updateUser: function(button) {
        var win    = button.up('window'),
            form   = win.down('form'),
            record = form.getRecord(),
            values = form.getValues();

        if (!Ext.isEmpty(values.id)){
            record.set(values);
        } else{
            record = Ext.create('ExtJSTest.model.User');
            record.set(values);
            record.setId(0);
            this.getUsersStore().add(record);
        }

        win.close();
        this.getUsersStore().sync();
    },

    deleteUser: function(button) {

        var grid = this.getContactlist(),
            record = grid.getSelectionModel().getSelection(),
            store = this.getUsersStore();

        store.remove(record);
        this.getUsersStore().sync();
    }
});