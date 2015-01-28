'use strict';

var gulp = require('gulp');
var browserSync = require('browser-sync');
var reload = browserSync.reload;
var $ = require('gulp-load-plugins')();


gulp.task('connect', function () {
    var connect = require('connect');
    var app = connect()
        .use(require('connect-livereload')({ port: 35729 }))
        .use(connect.static('src/main/webapp'))
        .use(connect.directory('src/main/webapp'));

    require('http').createServer(app)
        .listen(9000)
        .on('listening', function () {
            console.log('Started connect web server on http://localhost:9000');
        });
});


gulp.task('serve', ['connect'], function () {
    require('opn')('http://localhost:9000/prototype');
});



gulp.task('styles', function () {
    return gulp.src('src/main/webapp/assets/sass/**/*.scss')
        .pipe($.sass({errLogToConsole: true}))
        .pipe($.autoprefixer('last 1 version'))
        .pipe(gulp.dest('src/main/webapp/assets/css'))
        .pipe(reload({stream:true}))
//        .pipe($.notify("Compilation complete."))
        ;
});



gulp.task('scripts', function () {
    return gulp.src('src/main/webapp/assets/js/**/*.js')
        .pipe($.jshint())
        .pipe($.jshint.reporter(require('jshint-stylish')))
        .pipe($.size());
});



gulp.task('watch', ['connect', 'serve'], function () {
    var server = $.livereload();

    gulp.watch('src/main/webapp/assets/sass/**/*.scss', ['styles']);
    gulp.watch('src/main/webapp/assets/js/**/*.js', ['scripts']);
    gulp.watch([
        'src/main/webapp/prototype/**/*.html',
        'src/main/webapp/assets/css/**/*.css',
        'src/main/webapp/assets/sass/**/*.scss',
        'src/main/webapp/assets/js/**/*.js'
    ]).on('change', function (file) {
        server.changed(file.path);
    });

});

