/**
 * Created by levshevich_i on 29.10.15.
 */
Ext.application({
    name: 'ExtJSTest',

    controllers: [
        'Users'
    ],

    launch: function() {
        Ext.create('Ext.container.Viewport', {
            layout: 'fit',
            items: [
                {
                    xtype: 'contactlist'
                }
            ]
        });
    }
});