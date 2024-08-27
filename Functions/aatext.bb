Function aatext%(arg0%, arg1%, arg2$, arg3%, arg4%, arg5#)
    Local local0.aafont
    Local local1%
    Local local2%
    Local local3%
    Local local4%
    Local local5%
    Local local6%
    Local local7%
    Local local8%
    Local local9%
    Local local10%
    Local local11%
    If (len(arg2) = $00) Then
        Return $00
    EndIf
    local0 = (Object.aafont aaselectedfont)
    If ((((graphicsbuffer() <> backbuffer()) Or (aatextenable = $00)) Or (local0\Field10 = $00)) <> 0) Then
        setfont(local0\Field6)
        local1 = colorred()
        local2 = colorgreen()
        local3 = colorblue()
        color((Int ((Float local1) * arg5)), (Int ((Float local2) * arg5)), (Int ((Float local3) * arg5)))
        text(arg0, arg1, arg2, arg3, arg4)
        color(local1, local2, local3)
        Return $00
    EndIf
    If (arg3 <> 0) Then
        arg0 = (arg0 - (aastringwidth(arg2) Sar $01))
    EndIf
    If (arg4 <> 0) Then
        arg1 = (arg1 - (aastringheight(arg2) Sar $01))
    EndIf
    If (camera <> $00) Then
        hideentity(camera)
    EndIf
    If (ark_blur_cam <> $00) Then
        hideentity(ark_blur_cam)
    EndIf
    local4 = $00
    cameraprojmode(aatextcam, $02)
    local6 = $00
    For local7 = $01 To len(arg2) Step $01
        local5 = asc(mid(arg2, local7, $01))
        If (((local5 >= $00) And (local5 <= $7F)) <> 0) Then
            local6 = (local6 + local0\Field4[local5])
        EndIf
    Next
    aacamvieww = local6
    aacamvieww = (aacamvieww + (aacamvieww Mod $02))
    aacamviewh = aastringheight(arg2)
    aacamviewh = (aacamviewh + (aacamviewh Mod $02))
    local8 = arg0
    If (local8 < $00) Then
        local8 = $00
    EndIf
    local9 = arg1
    If (local9 < $00) Then
        local9 = $00
    EndIf
    local10 = ((arg0 - local8) + aacamvieww)
    If ((local10 + local8) > graphicwidth) Then
        local10 = (graphicwidth - local8)
    EndIf
    local11 = ((arg1 - local9) + aacamviewh)
    If ((local11 + local9) > graphicheight) Then
        local11 = (graphicheight - local9)
    EndIf
    local10 = (local10 - (local10 Mod $02))
    local11 = (local11 - (local11 Mod $02))
    aacamviewh = (aacamviewh + (aacamviewh Mod $02))
    aacamvieww = local10
    aacamviewh = local11
    cameraviewport(aatextcam, local8, local9, local10, local11)
    For local7 = $01 To len(arg2) Step $01
        entityalpha(aatextsprite[(local7 - $01)], arg5)
        entitycolor(aatextsprite[(local7 - $01)], (Float colorred()), (Float colorgreen()), (Float colorblue()))
        showentity(aatextsprite[(local7 - $01)])
        local5 = asc(mid(arg2, local7, $01))
        If (((local5 >= $00) And (local5 <= $7F)) <> 0) Then
            aaspritescale((local7 - $01), local0\Field4[local5], local0\Field5[local5])
            aaspriteposition((local7 - $01), (((arg0 - local8) + local4) + (local0\Field4[local5] Sar $01)), ((arg1 - local9) + (local0\Field5[local5] Sar $01)))
            vertextexcoords(getsurface(aatextsprite[(local7 - $01)], $01), $00, ((Float local0\Field2[local5]) / 1024.0), ((Float local0\Field3[local5]) / 1024.0), 1.0, $00)
            vertextexcoords(getsurface(aatextsprite[(local7 - $01)], $01), $01, ((Float (local0\Field2[local5] + local0\Field4[local5])) / 1024.0), ((Float local0\Field3[local5]) / 1024.0), 1.0, $00)
            vertextexcoords(getsurface(aatextsprite[(local7 - $01)], $01), $02, ((Float local0\Field2[local5]) / 1024.0), ((Float (local0\Field3[local5] + local0\Field5[local5])) / 1024.0), 1.0, $00)
            vertextexcoords(getsurface(aatextsprite[(local7 - $01)], $01), $03, ((Float (local0\Field2[local5] + local0\Field4[local5])) / 1024.0), ((Float (local0\Field3[local5] + local0\Field5[local5])) / 1024.0), 1.0, $00)
            local4 = ((local0\Field4[local5] + local4) - $02)
        EndIf
    Next
    renderworld(1.0)
    cameraprojmode(aatextcam, $00)
    For local7 = $01 To len(arg2) Step $01
        hideentity(aatextsprite[(local7 - $01)])
    Next
    If (camera <> $00) Then
        showentity(camera)
    EndIf
    If (ark_blur_cam <> $00) Then
        showentity(ark_blur_cam)
    EndIf
    Return $00
End Function
