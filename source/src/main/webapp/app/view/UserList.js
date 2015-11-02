/**
 * Created by levshevich_i on 29.10.15.
 */
Ext.define('ExtJSTest.view.UserList' ,{
    extend: 'Ext.grid.Panel',
    alias : 'widget.contactlist',

    iconCls: 'icon-grid',

    title : 'Users',
    store: 'Users',

    columns: [{
        header: "firstname",
        width: 170,
        flex:1,
        dataIndex: 'firstname'
    },{
        header: "lastname",
        width: 170,
        flex:1,
        dataIndex: 'lastname'
    },{
        header: "telephone",
        width: 160,
        flex:1,
        dataIndex: 'telephone'
    },{
        header: "email",
        width: 170,
        flex:1,
        dataIndex: 'email'
    },{
        header: "password",
        width: 170,
        flex:1,
        dataIndex: 'password'
    }],

    initComponent: function() {

        this.dockedItems = [{
            xtype: 'toolbar',
            items: [{
                iconCls: 'icon-save',
                itemId: 'add',
                text: 'Add',
                action: 'add'
            },{
                iconCls: 'icon-delete',
                text: 'Delete',
                action: 'delete'
            }]
            },
            {
                xtype: 'pagingtoolbar',
                dock:'top',
                store: 'Users',
                displayInfo: true,
                displayMsg: 'Displaying users {0} - {1} of {2}',
                emptyMsg: "No users to display"
            }];

        this.callParent(arguments);
    }
});