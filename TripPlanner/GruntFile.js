const babel = require('rollup-plugin-babel');

module.exports = function(grunt) 
{
    require("load-grunt-tasks")(grunt); 
 
    grunt.initConfig({
    	
    	 
        babel: {
        	  options: {
        	    plugins: ['transform-react-jsx'],
        	    presets: ['es2015', 'react']
        	  },
        	  jsx: {
        	    files: [{
        	      expand: true,
        	      cwd: 'WebContent/resources/reactjs/', // Custom folder
        	      src: ['*.js', '**/*.js'],
        	      dest: 'WebContent/resources/compiledReact/', // Custom folder
        	      ext: '.js'
        	    }]
        	  }
        	  
        	},
        	
     rollup: {
        	      options: {
        	        plugins: function () {
        	          return [
        	            babel({
        	              exclude: './node_modules/**',
        	              presets: ['es2015-rollup'],
        	            }),
        	          ];
        	        },
        	      },
        	      main: {
        	        dest: 'WebContent/resources/reactjs/compiled/main.js',
        	        src: 'WebContent/resources/reactjs/compiled/index.js', // Only one source file is permitted
        	      },
        	    },
 /*  rollup: {
        options: {
       	    plugins: ['rollup-plugin-babel'],
    	    presets: ['es2015-rollup']
        },
        
        files: {
            'WebContent/resources/reactjs/compiled/main.js': ['WebContent/resources/reactjs/compiled/index.js'], // Only one source file is permitted 
          },
    	  main: {
      	    files: [{
      	     
      	      src: 'WebContent/resources/reactjs/compiled/index.js', // Custom folder
      	      dest: 'WebContent/resources/reactjs/compiled/main.js', // Custom folder
      	      
      	    }]
      	
    		  src: 'WebContent/resources/reactjs/compiled/index.js', // Custom folder
    	      dest: 'WebContent/resources/reactjs/compiled/main.js', // Custom folder
        
    	  }
       
      }*/
  });
      
    grunt.loadNpmTasks('grunt-rollup');
    grunt.registerTask('default', ['babel', 'rollup']);
}