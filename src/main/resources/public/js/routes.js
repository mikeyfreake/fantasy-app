'use strict'

var currentTag = null;
var routes = {
	home: function(id, action) {
		mount('home-page');
	},
	champions: function(id, action) {
		mount('champions-page');
	},
	rankings: function(id, action) {
		mount('rankings-page');
	},
	stats: function(id, action) {
		mount('stats-page');
	}
};

function mount(tag, options) {
  currentTag && currentTag.unmount(true);
  currentTag = riot.mount('#content', tag, options);
  if (currentTag)
	  currentTag = currentTag[0];
}

function handler(collection, id, action) {
  var fn = routes[collection || 'home'];
  fn ? fn(id, action) : mount('not-found-page');
}

riot.route(handler);