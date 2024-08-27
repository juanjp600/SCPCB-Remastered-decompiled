Function aaloadfont%(arg0$, arg1%, arg2%, arg3%, arg4%, arg5%)
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
    Local local12%
    Local local13%
    Local local14#
    Local local15#
    Local local16%
    Local local17%
    Local local18%
    Local local19%
    Local local20%
    Local local21%
    Local local22%
    Local local23%
    Local local24%
    local0 = (New aafont)
    local0\Field6 = loadfont(arg0, arg1, $00, $00, $00)
    setfont(local0\Field6)
    local0\Field7 = fontwidth()
    local0\Field8 = fontheight()
    If ((aatextenable And (arg5 > $01)) <> 0) Then
        local1 = loadfont(arg0, (arg1 * arg5), $00, $00, $00)
        local2 = createtexture($400, $400, $03, $01)
        local3 = $00
        local4 = $01
        setfont(local1)
        local5 = createimage((fontwidth() + (arg5 Shl $01)), (fontheight() + (arg5 Shl $01)), $01)
        clscolor($00, $00, $00)
        lockbuffer(texturebuffer(local2, $00))
        local6 = (local0\Field8 * (((local0\Field7 * $5F) Sar $0A) + $02))
        local0\Field7 = $00
        For local7 = $00 To $3FF Step $01
            For local8 = $00 To local6 Step $01
                writepixelfast(local7, local8, $FFFFFF, texturebuffer(local2, $00))
            Next
        Next
        For local9 = $20 To $7E Step $01
            setbuffer(imagebuffer(local5, $00))
            cls()
            color($FF, $FF, $FF)
            setfont(local1)
            text((arg5 Sar $01), (arg5 Sar $01), chr(local9), $00, $00)
            local10 = stringwidth(chr(local9))
            local11 = fontheight()
            setfont(local0\Field6)
            local12 = stringwidth(chr(local9))
            local13 = fontheight()
            local14 = ((Float local10) / (Float local12))
            local15 = ((Float local11) / (Float local13))
            setbuffer(backbuffer())
            lockbuffer(imagebuffer(local5, $00))
            For local8 = $00 To (local13 - $01) Step $01
                For local7 = $00 To (local12 - $01) Step $01
                    local16 = (Int (((Float local7) * local14) - (local14 * 0.0)))
                    If (local16 < $00) Then
                        local16 = $00
                    EndIf
                    local17 = (Int (((Float local8) * local15) - (local15 * 0.0)))
                    If (local17 < $00) Then
                        local17 = $00
                    EndIf
                    local18 = (Int (((Float local7) * local14) + (local14 * 1.0)))
                    If (local18 > local10) Then
                        local18 = (local10 - $01)
                    EndIf
                    local19 = (Int (((Float local8) * local15) + (local15 * 1.0)))
                    If (local19 > local11) Then
                        local19 = (local11 - $01)
                    EndIf
                    local20 = $00
                    If (((Abs (local16 - local18)) * (Abs (local17 - local19))) > $00) Then
                        For local21 = local17 To (local19 - $01) Step $01
                            For local22 = local16 To (local18 - $01) Step $01
                                local20 = (local20 + (readpixelfast(local22, local21, imagebuffer(local5, $00)) And $FF))
                            Next
                        Next
                        local20 = (local20 / ((Abs (local16 - local18)) * (Abs (local17 - local19))))
                        If (local20 > $FF) Then
                            local20 = $FF
                        EndIf
                        local20 = (Int ((((Float local20) / 255.0) ^ 0.5) * 255.0))
                    EndIf
                    writepixelfast((local7 + local3), (local8 + local4), ((local20 Shl $18) + $FFFFFF), texturebuffer(local2, $00))
                Next
            Next
            unlockbuffer(imagebuffer(local5, $00))
            local0\Field2[local9] = local3
            local0\Field3[local9] = local4
            local0\Field4[local9] = (local12 + $02)
            If (local0\Field7 < (local0\Field4[local9] - $03)) Then
                local0\Field7 = (local0\Field4[local9] - $03)
            EndIf
            local0\Field5[local9] = (local13 + $02)
            local3 = ((local0\Field4[local9] + local3) + $02)
            If (local3 > (($400 - fontwidth()) - $04)) Then
                local3 = $00
                local4 = ((fontheight() + local4) + $06)
            EndIf
        Next
        local0\Field9 = local6
        local23 = createimage($400, $400, $01)
        lockbuffer(imagebuffer(local23, $00))
        For local7 = $00 To $3FF Step $01
            For local8 = $00 To local0\Field9 Step $01
                local24 = (readpixelfast(local7, local8, texturebuffer(local2, $00)) Shr $18)
                local24 = (((local24 Shl $08) + local24) + (local24 Shl $10))
                writepixelfast(local7, local8, ($FF000000 + local24), imagebuffer(local23, $00))
            Next
        Next
        unlockbuffer(imagebuffer(local23, $00))
        local0\Field1 = local23
        unlockbuffer(texturebuffer(local2, $00))
        freeimage(local5)
        freefont(local1)
        local0\Field0 = local2
        local0\Field10 = $01
    Else
        local0\Field10 = $00
    EndIf
    Return (Handle local0)
    Return $00
End Function
