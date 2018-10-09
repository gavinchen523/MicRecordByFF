#include <jni.h>
#include <string>

extern "C"
{

#include <libavcodec/avcodec.h>
#include <libavformat/avformat.h>
#include <libavfilter/avfilter.h>
#include <libavdevice/avdevice.h>

JNIEXPORT jstring JNICALL
Java_com_example_gavin_micrecordbyff_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

JNIEXPORT jstring JNICALL
Java_com_example_gavin_micrecordbyff_MainActivity_inputdev(
        JNIEnv *env,
        jobject /* this */) {
    char info[40000] = {0};

    av_register_all();
    avdevice_register_all();
    AVFormatContext *pFormatCtx = avformat_alloc_context();

//    avformat_open_input(&pFormatCtx, "alsa", NULL, NULL);

    sprintf(info, "%sInput: %s\n", info, avformat_open_input(&pFormatCtx, "alsa", NULL, NULL));

    return env->NewStringUTF(info);
}


JNIEXPORT jstring JNICALL
Java_com_example_gavin_micrecordbyff_MainActivity_outputdev(
        JNIEnv *env,
        jobject /* this */) {
    char info[40000] = {0};

    av_register_all();


    return env->NewStringUTF(info);
}


}