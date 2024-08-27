Function playerinreachableroom%(arg0%)
    Local local0$
    Local local1.events
    Local local2%
    local0 = playerroom\Field7\Field10
    If (((((local0 = "pocketdimension") Or (local0 = "gatea")) Or (local0 = "dimension1499")) Or (local0 = "room173intro")) <> 0) Then
        Return $00
    EndIf
    If (((local0 = "gateb") And ((1040.0 * roomscale) < entityy(collider, $00))) <> 0) Then
        Return $00
    EndIf
    local2 = $00
    For local1 = Each events
        If (((local1\Field0 = "room860") And (1.0 = local1\Field2)) <> 0) Then
            local2 = $01
            Exit
        EndIf
    Next
    If (((local0 = "room860") And local2) <> 0) Then
        Return $00
    EndIf
    If (arg0 = $00) Then
        If (selecteddifficulty\Field3 = $00) Then
            If (((local0 = "room049") And ((-2848.0 * roomscale) >= entityy(collider, $00))) <> 0) Then
                Return $00
            EndIf
        EndIf
    EndIf
    Return $01
    Return $00
End Function
