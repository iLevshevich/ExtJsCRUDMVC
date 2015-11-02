/**
 * Created by levshevich_i on 29.10.15.
 */
Ext.define('ExtJSTest.view.UserEdit', {
    extend: 'Ext.window.Window',
    alias : 'widget.contactedit',

    requires: ['Ext.form.Panel','Ext.form.field.Text'],

    title : 'Edit user',
    layout: 'fit',
    autoShow: true,
    width: 280,

    iconCls: 'icon-user',

    initComponent: function() {
        this.items = [
            {
                xtype: 'form',
                padding: '5 5 0 5',
                border: false,
                style: 'background-color: #fff;',

                fieldDefaults: {
                    anchor: '100%',
                    labelAlign: 'left',
                    allowBlank: false,
                    combineErrors: true,
                    msgTarget: 'side'
                },

                items: [
                    {
                        xtype: 'textfield',
                        name : 'id',
                        fieldLabel: 'id',
                        hidden:true
                    },
                    {
                        xtype: 'textfield',
                        name : 'firstname',
                        fieldLabel: 'firstname'
                    },
                    {
                        xtype: 'textfield',
                        name : 'lastname',
                        fieldLabel: 'lastname'
                    },
                    {
                        xtype: 'textfield',
                        name : 'telephone',
                        fieldLabel: 'telephone'
                    },
                    {
                        xtype: 'textfield',
                        name : 'email',
                        fieldLabel: 'email'
                    },
                    {
                        xtype: 'textfield',
                        name : 'password',
                        fieldLabel: 'password'
                    },
                    {
                        xtype: 'textfield',
                        name : 'created',
                        fieldLabel: 'created',
                        hidden:true
                    },
                    {
                        xtype: 'textfield',
                        name : 'modified',
                        fieldLabel: 'modified',
                        hidden:true
                    }
                ]
            }
        ];

        this.dockedItems = [{
            xtype: 'toolbar',
            dock: 'bottom',
            id:'buttons',
            ui: 'footer',
            items: ['->', {
                iconCls: 'icon-save',
                itemId: 'save',
                text: 'Save',
                action: 'save'
            },{
                iconCls: 'icon-reset',
                text: 'Cancel',
                scope: this,
                handler: this.close
            }]
        }];

        this.callParent(arguments);
    }
});