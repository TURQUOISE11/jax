package cn.lhemi.jax;

import cn.lhemi.jax.repository.CtxRepository;
import cn.lhemi.jax.repository.DeviceRepository;
import cn.lhemi.jax.util.RemoteAddressUtil;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;

import java.util.Collection;
import java.util.Set;

/**
 * @description: Jax工具
 * @author: TURQUOISE
 * @create: 2019-08-08 15:05
 */
public class Jax {

    /**
     * 单个发送
     *
     * @param ctx     ctx
     * @param message message
     * @return ChannelFuture
     */
    public static ChannelFuture send(ChannelHandlerContext ctx, Object message) {
        return ctx.writeAndFlush(message);
    }

    /**
     * 连接数
     *
     * @return int
     */
    public static int connectionsCount() {
        CtxRepository ctxRepository = JaxSpringContextUtil.getCtxRepository();
        return ctxRepository.sizeCtxCache();
    }

    /**
     * device连接数
     *
     * @return int
     */
    public static int deviceCount() {
        DeviceRepository deviceRepository = JaxSpringContextUtil.getDeviceRepository();
        return deviceRepository.sizeDeviceCache();
    }

    /**
     * 批量发送给所有device
     *
     * @param message message
     * @return ChannelFuture
     */
    public static void send2All(Object message) {
        allCtx().forEach(ctx -> send(ctx, message));
    }

    /**
     * 批量发送给所有device
     *
     * @param message message
     * @return ChannelFuture
     */
    public static void send2AllDevice(Object message) {
        allDeviceCtx().forEach(ctx -> send(ctx, message));
    }


    /**
     * 所有deviceId
     *
     * @return Set<String>
     */
    public static Set<String> allDeviceId() {
        DeviceRepository deviceRepository = JaxSpringContextUtil.getDeviceRepository();
        return deviceRepository.getChannelHandlerContextCache().keySet();
    }

    /**
     * 所有device的ctx
     *
     * @return Set<String>
     */
    public static Collection<ChannelHandlerContext> allDeviceCtx() {
        DeviceRepository deviceRepository = JaxSpringContextUtil.getDeviceRepository();
        return deviceRepository.getChannelHandlerContextCache().values();
    }

    /**
     * 通过remoteAddress获取ctx
     *
     * @param remoteAddress remoteAddress
     * @return ChannelHandlerContext
     */
    public static ChannelHandlerContext getCtxByRemoteAddress(String remoteAddress) {
        CtxRepository ctxRepository = JaxSpringContextUtil.getCtxRepository();
        return ctxRepository.getCtxCache(remoteAddress);
    }

    /**
     * 所有deviceId
     *
     * @return Set<String>
     */
    public static Set<String> allRemoteAddress() {
        CtxRepository ctxRepository = JaxSpringContextUtil.getCtxRepository();
        return ctxRepository.getChannelHandlerContextCache().keySet();
    }


    /**
     * 所有device的ctx
     *
     * @return Set<String>
     */
    public static Collection<ChannelHandlerContext> allCtx() {
        CtxRepository ctxRepository = JaxSpringContextUtil.getCtxRepository();
        return ctxRepository.getChannelHandlerContextCache().values();
    }

    /**
     * 通过deviceId获取ctx
     *
     * @param deviceId deviceId
     * @return ChannelHandlerContext
     */
    public static ChannelHandlerContext getCtxByDeviceId(String deviceId) {
        DeviceRepository deviceRepository = JaxSpringContextUtil.getDeviceRepository();
        return deviceRepository.getDeviceCache(deviceId);
    }

    /**
     * 缓存ctx   remoteAddress===>ctx
     *
     * @param ctx ctx
     * @return boolean
     */
    public static boolean bindCtx(ChannelHandlerContext ctx) {
        CtxRepository ctxRepository = JaxSpringContextUtil.getCtxRepository();
        String remoteAddress = RemoteAddressUtil.address(ctx);
        if (ctxRepository.containsKey(remoteAddress)) {
            return false;
        }
        ctxRepository.putCtxCache(remoteAddress, ctx);
        return true;
    }

    /**
     * 更新或缓存ctx   remoteAddress===>ctx
     *
     * @param ctx ctx
     * @return boolean
     */
    public static boolean bindOrUpdateCtx(ChannelHandlerContext ctx) {
        CtxRepository ctxRepository = JaxSpringContextUtil.getCtxRepository();
        String remoteAddress = RemoteAddressUtil.address(ctx);
        ctxRepository.putCtxCache(remoteAddress, ctx);
        return true;
    }

    /**
     * 是否已缓存   remoteAddress===>ctx
     *
     * @param ctx ctx
     * @return boolean
     */
    public static boolean isBindCtx(ChannelHandlerContext ctx) {
        CtxRepository ctxRepository = JaxSpringContextUtil.getCtxRepository();
        String remoteAddress = RemoteAddressUtil.address(ctx);
        return ctxRepository.containsKey(remoteAddress);
    }

    /**
     * 取消缓存 通过remoteAddress
     *
     * @param ctx ctx
     * @return boolean
     */
    public static boolean unbindCtx(ChannelHandlerContext ctx) {
        CtxRepository ctxRepository = JaxSpringContextUtil.getCtxRepository();
        String remoteAddress = RemoteAddressUtil.address(ctx);
        if (ctxRepository.containsKey(remoteAddress)) {
            ctxRepository.removeCtxCache(remoteAddress);
            return false;
        }
        return true;
    }


    /**
     * 缓存Device   deviceId===>ctx
     *
     * @param ctx      ctx
     * @param deviceId deviceId
     * @return boolean
     */
    public static boolean bindDevice(ChannelHandlerContext ctx, String deviceId) {
        DeviceRepository deviceRepository = JaxSpringContextUtil.getDeviceRepository();
        if (deviceRepository.containsKey(deviceId)) {
            return false;
        }
        deviceRepository.putDeviceCache(deviceId, ctx);
        return true;
    }

    /**
     * 缓存Device   deviceId===>ctx
     *
     * @param ctx      ctx
     * @param deviceId deviceId
     * @return boolean
     */
    public static boolean bindOrUpdateDevice(ChannelHandlerContext ctx, String deviceId) {
        DeviceRepository deviceRepository = JaxSpringContextUtil.getDeviceRepository();
        if (deviceRepository.containsKey(deviceId)) {
            return false;
        }
        deviceRepository.putDeviceCache(deviceId, ctx);
        return true;
    }

    /**
     * 是否已缓存Device   deviceId===>ctx
     *
     * @param deviceId deviceId
     * @return boolean
     */
    public static boolean isBindOrUpdateDevice(String deviceId) {
        DeviceRepository deviceRepository = JaxSpringContextUtil.getDeviceRepository();
        return deviceRepository.containsKey(deviceId);
    }

    /**
     * 是否已缓存Device   deviceId===>ctx
     *
     * @param deviceId deviceId
     * @return boolean
     */
    public static boolean unbindOrUpdateDevice(String deviceId) {
        DeviceRepository deviceRepository = JaxSpringContextUtil.getDeviceRepository();
        if (deviceRepository.containsKey(deviceId)) {
            deviceRepository.removeDeviceCache(deviceId);
            return true;
        }
        return false;
    }
}
